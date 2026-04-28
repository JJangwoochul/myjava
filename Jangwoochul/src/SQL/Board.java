package SQL;

import java.util.Date;

public class Board {
    private int bNo;
    private String bTitle;
    private String bContent;
    private String bWriter;
    private Date bDate;
    private String bFilename;

    public int getbNo() {
        return bNo;
    }

    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public String getbWriter() {
        return bWriter;
    }

    public void setbWriter(String bWriter) {
        this.bWriter = bWriter;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getbFilename() {
        return bFilename;
    }

    public void setbFilename(String bFilename) {
        this.bFilename = bFilename;
    }

    @Override
    public String toString() {
        return "Board { " + "\nbno = " + bNo + " \nbtitle = " + bTitle + "\nbcontent = " + bContent + "\nbwriter = "
                + bWriter + "\nbdate = " + bDate + "\nbfilename = " + bFilename + '}';
    }
}
