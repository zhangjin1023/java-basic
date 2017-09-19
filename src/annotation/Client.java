package annotation;

import java.lang.annotation.Annotation;

@Tag
public class Client {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Client client = new Client();
		client.client();
	}
	@Tag(name="jjj")
	public void client() throws NoSuchMethodException, SecurityException{
		Annotation[] annotations = this.getClass().getAnnotations();
		Annotation[] annotations2 = this.getClass().getDeclaredMethod("client", new Class[]{}).getAnnotations();
		for(Annotation annotation:annotations){
			if (annotation instanceof Tag) {
				Tag tag = (Tag)annotation;
				System.out.println("name: " + tag.name());
				System.out.println("desc: " + tag.desc());
			}
		}
		
		for(Annotation annotation:annotations2){
			if (annotation instanceof Tag) {
				Tag tag = (Tag)annotation;
				System.out.println("name: " + tag.name());
				System.out.println("desc: " + tag.desc());
			}
		}
	}

}
