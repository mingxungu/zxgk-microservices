package cn.com.pingtech.senseFace.pojo;

/**
 * @Auther: psf
 * @Date: 2019/9/2 13:22
 * @Description:
 */
public class DB {
    private String db_id;
    private int top_k;
    private double min_score;

    public String getDb_id() {
        return db_id;
    }

    public void setDb_id(String db_id) {
        this.db_id = db_id;
    }

    public int getTop_k() {
        return top_k;
    }

    public void setTop_k(int top_k) {
        this.top_k = top_k;
    }

    public double getMin_score() {
        return min_score;
    }

    public void setMin_score(double min_score) {
        this.min_score = min_score;
    }

    public DB(String db_id, int top_k, double min_score) {
        this.db_id = db_id;
        this.top_k = top_k;
        this.min_score = min_score;
    }

    public DB() {
    }
}
