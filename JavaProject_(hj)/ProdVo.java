package vo;

import java.math.BigDecimal;

public class ProdVo {
//	String prod_name = (String)map.get("PROD_NAME");
//	BigDecimal prod_cost = (BigDecimal)map.get("PROD_COST");
//	String prod_color = (String)map.get("PROD_COLOR");
//	String prod_outline = (String)map.get("PROD_OUTLINE");

	private String prod_id;
	private String prod_name;
	private String prod_lgu;
	private BigDecimal prod_cost;
	private String prod_outline;
	private String prod_color;

	
	
	@Override
	public String toString() {
		return "ProdVo [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_lgu=" + prod_lgu + ", prod_cost="
				+ prod_cost + ", prod_outline=" + prod_outline + ", prod_color=" + prod_color + "]";
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_lgu() {
		return prod_lgu;
	}

	public void setProd_lgu(String prod_lgu) {
		this.prod_lgu = prod_lgu;
	}

	public BigDecimal getProd_cost() {
		return prod_cost;
	}

	public void setProd_cost(BigDecimal prod_cost) {
		this.prod_cost = prod_cost;
	}

	public String getProd_outline() {
		return prod_outline;
	}

	public void setProd_outline(String prod_outline) {
		this.prod_outline = prod_outline;
	}

	public String getProd_color() {
		return prod_color;
	}

	public void setProd_color(String prod_color) {
		this.prod_color = prod_color;
	}

}
