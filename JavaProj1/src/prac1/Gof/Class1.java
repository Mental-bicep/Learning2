package prac1.Gof;



interface Notification{
	
}

class EmailNotificationService implements Notification{
	
}

class SmsNotificationService implements Notification{
	
}

class PushNotificationService implements Notification{
	
}

class NotificationFactory{
	
	public Notification getNotification(String type) {
		return switch(type) {
			case "EmailNotification" -> new EmailNotificationService();
			case "SmsNotification" -> new SmsNotificationService();
			case "PushNotification" -> new PushNotificationService();
			default -> null;
		};
	}
	
}


class Configuration {
	
	private static volatile Configuration configuration;
	
	private Configuration() {
		System.out.println("config obj got created");
	}
	
	public static Configuration getConfiguration() {
		if(configuration == null) {
			synchronized (Configuration.class) {
				if(configuration == null) 
					configuration = new Configuration();
			}
		}
		return configuration;
	}
	
}

interface PaymentProcessor{
	
}

class CreditCardPayment implements PaymentProcessor{
	
}

class UpiPayment implements PaymentProcessor{
	
}

class WalletPayment implements PaymentProcessor{
	
}

class PaymentProcessorFactory{
	
	public PaymentProcessor getPaymentProcessor(String name) {
		return switch(name) {
		case "CreditCard" -> new CreditCardPayment(); 
		case "UpiPayment" -> new UpiPayment();
		case "WalletPayment" -> new WalletPayment();
		default -> null;
		};
	}
	
}

class CacheManager{
	
	private static volatile CacheManager cacheManager; 
	
	private CacheManager() {
		System.out.println("Cache manager obj got created");
	}
	
	public CacheManager getCacheManager() {
		if(cacheManager == null) {
			synchronized(CacheManager.class) {
				if(cacheManager == null) 
					cacheManager = new CacheManager();
			}
		}
		return cacheManager;
	}
	
}

interface FileParser {}

class CsvParser implements FileParser{};
class JsonParser implements FileParser{};
class XmlParser implements FileParser{};

class FileParserFactory {
	
	public FileParser getFileParser(String type) {
		return switch(type) {
		case "csv" -> new CsvParser();
		case "json" -> new JsonParser();
		case "xml" -> new XmlParser();
		default -> throw new IllegalArgumentException("Invalid notofication type");
		};
	}
}

public class Class1 {

}
