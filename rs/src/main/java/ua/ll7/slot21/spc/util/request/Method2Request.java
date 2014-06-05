package ua.ll7.slot21.spc.util.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Alex Velichko
 *         03.06.14 : 12:40
 */
@XmlRootElement(name="m2request")
public class Method2Request implements Serializable {

	@XmlElement(name="v1")
	public long getV1() {
		return v1;
	}

	public void setV1(long v1) {
		this.v1 = v1;
	}

	@XmlElement(name="v2")
	public long getV2() {
		return v2;
	}

	public void setV2(long v2) {
		this.v2 = v2;
	}

	@XmlElement(name="v3")
	public long getV3() {
		return v3;
	}

	public void setV3(long v3) {
		this.v3 = v3;
	}

	public Method2Request() {
	}

	public Method2Request(long v1, long v2, long v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Method2Request{");
		sb.append("v1=").append(v1);
		sb.append(", v2=").append(v2);
		sb.append(", v3=").append(v3);
		sb.append('}');
		return sb.toString();
	}

	private long v1;
	private long v2;
	private long v3;
}
