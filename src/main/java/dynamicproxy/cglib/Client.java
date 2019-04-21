package dynamicproxy.cglib;

public class Client {
    public static void main(String[] args) {
        CarInterceptor carInterceptor = new CarInterceptor();
        Car proxy = (Car) carInterceptor.getproxyInstance(new Car());
        proxy.move();
    }

}
