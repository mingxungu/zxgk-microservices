package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

public class PeopleAlongVo {
   
	private String _id; //id
    private String peopleName;
    private String idNumber;
    private String startTime;//关联开始时间
    private String endTime;//关联结束时间
    private String similarity;//伴随度
    private String aName;
    private String peopleAlongCount;
    private String minSimilarity;
    private String aId;
    private String bId;
    private String bName;
    private String count;
    private String totalSimilarity;
    private String alongIdNumber;

	private int id;
	private int page;
	private int size;
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTotalSimilarity() {
		return totalSimilarity;
	}
	public void setTotalSimilarity(String totalSimilarity) {
		this.totalSimilarity = totalSimilarity;
	}
	
	public String getPeopleAlongCount() {
		return peopleAlongCount;
	}
	public void setPeopleAlongCount(String peopleAlongCount) {
		this.peopleAlongCount = peopleAlongCount;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
	public String getSimilarity() {
		return similarity;
	}
	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}
	public String getMinSimilarity() {
		return minSimilarity;
	}
	public void setMinSimilarity(String minSimilarity) {
		this.minSimilarity = minSimilarity;
	}
	public String getAlongIdNumber() {
		return alongIdNumber;
	}
	public void setAlongIdNumber(String alongIdNumber) {
		this.alongIdNumber = alongIdNumber;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
