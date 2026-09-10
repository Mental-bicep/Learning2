package solidprinciples;

//1. User Model: Responsible ONLY for holding user data
class User {
 private String name;
 private String email;
 private String password;

 public User(String name, String email, String password) {
     this.name = name;
     this.email = email;
     this.password = password;
 }

 // Getters and Setters
 public String getName() { return name; }
 public String getEmail() { return email; }
}

//2. UserRepository: Responsible ONLY for database operations
class UserRepository {
 public void save(User user) {
     System.out.println("Saving user to database: " + user.getName());
 }
}

//3. LoggerService: Responsible ONLY for logging messages
class LoggerService {
 public void log(String message) {
     System.out.println("LOG: " + message);
 }
}

//4. EmailService: Responsible ONLY for email communications
class EmailService {
 public void sendWelcomeEmail(String email) {
     System.out.println("Sending welcome email to: " + email);
 }
}

//5. UserService: Orchestrates the registration process
class UserService {
 private UserRepository repository = new UserRepository();
 private EmailService emailService = new EmailService();
 private LoggerService logger = new LoggerService();

 public void registerUser(String name, String email, String password) {
     // Step 1: Logic like hashing password would go here
     User user = new User(name, email, password);

     // Step 2: Save to DB
     repository.save(user);

     // Step 3: Send Email
     emailService.sendWelcomeEmail(user.getEmail());

     // Step 4: Log the event
     logger.log("New user registered: " + user.getName());
 }
}

public class SingleResponsibilityPrinciple {

}
