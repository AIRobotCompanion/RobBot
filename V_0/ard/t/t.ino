const int p=2;
char d;
void setup(){
	pinMode(p,OUTPUT);
  Serial.begin(9600);
}
void loop(){
	if(Serial.available()>0){
		d=Serial.read();
    //Serial.println(d);
		rf_send(d);
	}
	delay(1000);
}
void rf_send(byte input){
	int i;
	for(i=0;i<20;i++){
		digitalWrite(p,HIGH);
		delayMicroseconds(500);
		digitalWrite(p,LOW);
		delayMicroseconds(500);
	}
	digitalWrite(p,HIGH);
	delayMicroseconds(3000);
	digitalWrite(p,LOW);
	delayMicroseconds(500);
	for(i=0;i<8;i++){
		if(bitRead(input,i)==1)
			digitalWrite(p,HIGH);
		else
			digitalWrite(p,LOW);
		delayMicroseconds(500);
		if(bitRead(input,i)==1)
			digitalWrite(p,LOW);
		else
			digitalWrite(p,HIGH);
		delayMicroseconds(500);
	}
	digitalWrite(p,LOW);
}
