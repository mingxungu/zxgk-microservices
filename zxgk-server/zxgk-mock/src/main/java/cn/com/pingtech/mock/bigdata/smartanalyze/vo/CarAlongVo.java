package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataRequestVo;
import lombok.Data;

/**
 * @author linyd
 * @date 2019-06-20
 */
@Data
public class CarAlongVo extends BigDataRequestVo {

    private String _id;
	private String aCarNumber;//车牌号码
    private String aCarType;//车辆类型
    private String aCarColor;  //车牌颜色
    private String bCarNumber;//车牌号码
    private String bCarType;//车辆类型
    private String bCarColor;
    private String startTime;//关联开始时间
    private String endTime;//关联结束时间
    private String minSimilarity;//伴随度
    private String docCount;   //伴随车辆数
    private String similarity; //伴随度
    private String totalSimilarity;//总伴随度
    private String count;

	private int id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getaCarNumber() {
		return aCarNumber;
	}

	public void setaCarNumber(String aCarNumber) {
		this.aCarNumber = aCarNumber;
	}

	public String getaCarType() {
		return aCarType;
	}

	public void setaCarType(String aCarType) {
		this.aCarType = aCarType;
	}

	public String getaCarColor() {
		return aCarColor;
	}

	public void setaCarColor(String aCarColor) {
		this.aCarColor = aCarColor;
	}

	public String getbCarNumber() {
		return bCarNumber;
	}

	public void setbCarNumber(String bCarNumber) {
		this.bCarNumber = bCarNumber;
	}

	public String getbCarType() {
		return bCarType;
	}

	public void setbCarType(String bCarType) {
		this.bCarType = bCarType;
	}

	public String getbCarColor() {
		return bCarColor;
	}

	public void setbCarColor(String bCarColor) {
		this.bCarColor = bCarColor;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMinSimilarity() {
		return minSimilarity;
	}

	public void setMinSimilarity(String minSimilarity) {
		this.minSimilarity = minSimilarity;
	}

	public String getDocCount() {
		return docCount;
	}

	public void setDocCount(String docCount) {
		this.docCount = docCount;
	}

	public String getSimilarity() {
		return similarity;
	}

	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}

	public String getTotalSimilarity() {
		return totalSimilarity;
	}

	public void setTotalSimilarity(String totalSimilarity) {
		this.totalSimilarity = totalSimilarity;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
