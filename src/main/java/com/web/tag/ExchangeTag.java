package com.web.tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/*
    USDJPY=x
    CNYEUR=x

    <my:exchange symbol="USDTWD" />
    1 USD 兌換 29.8 TWD
    <my:exchange symbol="USDTWD"  reverse="true" />
    1 USD 兌換 29.8 TWD
    1 TWD 兌換 0.034 USD
 */
public class ExchangeTag implements Tag {

    private PageContext pageContent;
    private Tag parentTag;
    private String symbol;

    @Override
    public void setPageContext(PageContext pc) {
        pageContent = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContent.getOut();
        try {
            if (symbol != null && symbol.length() == 8) {
                Stock stock = YahooFinance.get(symbol);
                if (stock != null) {
                    double price = stock.getQuote().getPrice().doubleValue();
                    out.print("1 ");
                    out.print(symbol.substring(0, 3) + " ");
                    out.print(price + " ");
                    out.print(symbol.substring(3, 6) + " <p />");
                } else {
                    out.print("無此商品匯率" + symbol);
                }
            } else {
                out.print("symbol 格式錯誤: " + symbol);
            }
            
        } catch (Exception e) {
            try {
                out.print("Exception: " + e);
            } catch (Exception e2) {

            }
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

}
