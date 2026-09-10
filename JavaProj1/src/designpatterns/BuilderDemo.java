package designpatterns;

//1. The Immutable Product
class Email {
 private final String to;
 private final String subject;
 private final String body;
 private final String cc; // Optional

 // Private constructor: Only the Builder can call this
 private Email(Builder builder) {
     this.to = builder.to;
     this.subject = builder.subject;
     this.body = builder.body;
     this.cc = builder.cc;
 }

 // Getters only (No Setters = Immutable)
 public String getTo() { return to; }

 // 2. The Builder
 public static class Builder {
     private String to;
     private String subject;
     private String body;
     private String cc;

     public Builder setTo(String to) { this.to = to; return this; }
     public Builder setSubject(String subject) { this.subject = subject; return this; }
     public Builder setBody(String body) { this.body = body; return this; }
     public Builder setCc(String cc) { this.cc = cc; return this; }

     // The "Build" method returns the final object
     public Email build() {
         return new Email(this);
     }
 }
}



public class BuilderDemo {
	
	public static void main(String [] args) {
		//Usage
		Email mail = new Email.Builder()
		             .setTo("user@example.com")
		             .setSubject("Hello")
		             .setBody("Builder Pattern is cool!")
		             .build();
	}
	
}
