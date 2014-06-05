package ua.ll7.slot21.spc.util.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Velichko
 *         04.06.14 : 20:41
 */
@XmlRootElement(name = "methodResponse")
public class MethodResponse {
	private long data;

	@XmlElement(name="data")
	public long getData() {
		return data;
	}

	public MethodResponse() {}

	public MethodResponse(long l) {
		data=l;
	}

	public void setData(long data) {
		this.data = data;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MethodResponse{");
		sb.append("data=").append(data);
		sb.append('}');
		return sb.toString();
	}
}
