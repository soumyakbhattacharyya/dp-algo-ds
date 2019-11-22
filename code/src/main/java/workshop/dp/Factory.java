package workshop.dp;

public class Factory {

	enum MATERIAL {
		WOOD, STEEL, PLASTIC;

	}

	static class Door {
		MATERIAL material;
		float height;
		float width;

		Door(MATERIAL material, float height, float width) {
			super();

			this.material = material;
			this.height = height;
			this.width = width;
		}

		@Override
		public String toString() {
			return "Door [material=" + material + ", height=" + height + ", width=" + width + "]";
		}

	}

	public static Door create(String material, float height, float width) {

		// validation

		if (width > height) {
			throw new AssertionError("width should be smaller than height");
		}
		MATERIAL arg = null;
		try {
			arg = MATERIAL.valueOf(material.toUpperCase());
		} catch (IllegalArgumentException ex) {
			throw new AssertionError("unsupported material type");
		}

		return new Door(arg, height, width);
	}

}
