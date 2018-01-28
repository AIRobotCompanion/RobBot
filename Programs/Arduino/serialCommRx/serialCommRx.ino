void setup(){
  Serial.begin(9600);
}
void loop(){
  int d;
  while(Serial.available()){
    d=Serial.read();
    Serial.println(d);
  }
}
