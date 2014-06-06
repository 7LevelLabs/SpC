package ua.ll7.slot21.spc.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Alex Velichko
 *         02.06.14 : 22:42
 */

/**
 * F1[x]
 */
@Entity
@ApiModel(value = "F1 data", description = "F1[x] data")
public class F1 implements Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public long getId() {
		return id;
	}

	@Column
	@ApiModelProperty(value = "Payload", required = true)
	public long getValue() {
		return value;
	}

	public F1() {
	}

	public F1(Long aLong) {
		this.value = aLong;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("F1{");
		sb.append("id=").append(id);
		sb.append(", value=").append(value);
		sb.append('}');
		return sb.toString();
	}

	public F1(int value) {
		this.value = value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public void setId(long id) {
		this.id = id;
	}

	private long id;

	private long value = 0;

}
