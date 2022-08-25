package pageUI.jQuery;

public class HomePageUI {

	public static final String PAGINATION_PAGE_BY_NUMBER  ="xpath=//ul[contains(@class, 'qgrd-pagina')]//a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr['%s']/td['%s']/input";
}
