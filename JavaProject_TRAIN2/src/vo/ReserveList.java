package vo;

import lombok.Data;

@Data
public class ReserveList {
	private int by_no;
	private String by_date;
	private String tr_st;
	private String tr_ed;
	private String tr_si;
	private String tr_ei;
	private String cl_name;
	private String se_no;
	private int by_price;
}
