package com.simon.service.impl;

public class LoanHtmlUtil {

	/**
	 * 获取样式html
	 * @param html
	 * @return
	 */
	public static StringBuffer getStlye(StringBuffer html) {
		html.append("<style>");
		html.append(".table_border{");
		html.append("border: solid 1px #B4B4B4;");
		html.append("border-collapse: collapse;");
		html.append("}");
		html.append(".table_border tr th{");
		html.append("    padding-left:4px;");
		html.append("    height:27px;");
		html.append("    border: solid 1px #B4B4B4;");
		html.append("}");
		html.append(".table_border tr td{");
		html.append("    height:25px;");
		html.append("    padding:4px;");
		html.append("    border: solid 1px #B4B4B4;");
		html.append("}");
		html.append("</style>");
		return html;
	}
	/**
	 * 获取表头html
	 * @param html
	 * @param titleName
	 * @return
	 */
	public static StringBuffer getTableStart(StringBuffer html, String titleName) {
		html.append("<h2 style='text-align:center'>"+titleName+"</h2>");
//		html +="		    <table width="100%" cellspacing="0" cellpadding="0" >             ";
//		html +="		    	<tr>                                                          ";
//		html +="		    		<td width="30%">网点号: <span id="saleinfoCode">"+list[0].saleinfoCode+"</span></td> 	";
//		html +="		    		<td width="45%">日期: <span id="printDate">"+getLocalDate()+"</span></td>     			";
//		html +="		    		<td width="25%">单号: <span id="beanId">"+list[0].id+"</span></td>        				";
//		html +="		    	</tr>                                                         ";
//		html +="		    </table>                                                          ";
		//表格开始 表头
		html.append("<table class='table_border' width='100%' border='0' id='high_light' lang='tabRowData' cellpadding='0' cellspacing='0'>");
		html.append("<tr style='color: #000;'>");
		html.append("<th style='text-align: center' width='20%'>LoanId</th>");
		html.append("<th style='text-align: center' width='25%'>渠道订单号</th>");
		html.append("<th style='text-align: center' width='25%'>UserId</th>");
		html.append("<th style='text-align: center' width='25%'>超时时间(h)</th>");
		html.append("</tr>");
		return html;
	}
	
	/**
	 * 获取每行的html
	 * @param html
	 * @param loanId
	 * @param channelNo
	 * @param userId
	 * @param overTime
	 * @return
	 */
	public static StringBuffer getOneLine(StringBuffer html, String loanId, String channelNo, String userId, float overTime) {
		html.append("<tr style='color: #000;'>");
		html.append("<td style='text-align: center' width='20%'>"+ loanId +"</td>");
		html.append("<td style='text-align: center' width='25%'>"+ channelNo +"</td>");
		html.append("<td style='text-align: center' width='25%'>"+ userId +"</td>");
		html.append("<td style='text-align: center' width='25%'>"+ overTime +"</td>");
		html.append("</tr>");
		return html;
	}
	/**
	 * 获取表尾html
	 * @param html
	 * @param titleName
	 * @return
	 */
	public static StringBuffer getTableEnd(StringBuffer html) {
		html.append("</table>");
		return html;
	}
	/**
	 * 获取dev开始 html
	 * @param html
	 * @param titleName
	 * @return
	 */
	public static StringBuffer getDevStart(StringBuffer html) {
		html.append("<dev>");
		return html;
	}
	/**
	 * 获取dev 结束 html
	 * @param html
	 * @param titleName
	 * @return
	 */
	public static StringBuffer getDevEnd(StringBuffer html) {
		html.append("</dev>");
		return html;
	}
	
	/**
	 * 获取空行
	 * @param html
	 * @param titleName
	 * @return
	 */
	public static StringBuffer getBr(StringBuffer html) {
		html.append("</br>");
		return html;
	}

}
