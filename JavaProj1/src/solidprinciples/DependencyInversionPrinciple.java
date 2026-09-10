package solidprinciples;

//1. The Abstraction (Interface)
interface IRepository {
 void save(String data);
}

//2. Low-level details (Implementations)
class SQLRepository implements IRepository {
 public void save(String data) { System.out.println("Saved to SQL"); }
}

class MongoRepository implements IRepository {
 public void save(String data) { System.out.println("Saved to MongoDB"); }
}

//3. High-level module (Service) - Depends on the Interface
class UserService {
 private IRepository repository;

 // Use Dependency Injection to provide the specific implementation
 public UserService(IRepository repository) {
     this.repository = repository;
 }

 public void register(String data) {
     repository.save(data);
 }
}

public class DependencyInversionPrinciple {

}
