package annotation.ext;

import annotation.ext.FruitColor.Color;

public class Apple {

	@FruitName("Apple")
	private String name;
	@FruitColor(fruitColor = Color.RED)
	private String color;
	@FruitProvider(id = 1, name = "江西赣州红苹果产地", address = "江西省定南县")
	private String provider;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}
