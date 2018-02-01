public class Member {       
    String name;
    String msg;   
    int msgCount =0;

    public int getMsgCount() {
		return msgCount;
	}

	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
		msgCount ++;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
    	  return "Member: " + name + ", " + msgCount;
    	}
}