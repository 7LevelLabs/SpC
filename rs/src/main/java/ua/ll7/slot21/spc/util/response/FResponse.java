package ua.ll7.slot21.spc.util.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Velichko
 *         05.06.14 : 18:02
 */
@XmlRootElement(name = "fResponse")
public class FResponse {

	@XmlElement(name = "data")
	private String data;

	public FResponse() {
	}

	public FResponse(String data) {
		this.data = data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("FResponse{");
		sb.append("data='").append(data).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
