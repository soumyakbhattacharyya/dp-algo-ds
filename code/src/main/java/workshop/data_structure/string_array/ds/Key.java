package workshop.data_structure.string_array.ds;

public class Key {

	private final String _content;

	public Key(String _content) {
		super();
		this._content = _content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_content == null) ? 0 : _content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (_content == null) {
			if (other._content != null)
				return false;
		} else if (!_content.equals(other._content))
			return false;
		return true;
	}

	public String get_content() {
		return _content;
	}

}
