package json;

public class Girl {
	private String name;
	private long id;

	public Girl() {
	}

	public Girl(String name, long id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + ", id=" + id + "]";
	}

}
