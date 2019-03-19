package com.hua.common.object;

import com.hua.common.constant.Constants;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatUtil extends XmlAdapter<String,Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT,Locale.CANADA);

    @Override
    public Date unmarshal(String v) throws Exception {
        return simpleDateFormat.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return simpleDateFormat.format(v);
    }
}
