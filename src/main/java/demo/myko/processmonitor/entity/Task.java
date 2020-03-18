package demo.myko.processmonitor.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
    private String name;
    @XmlTransient
    private String pid;
    @XmlElement(name = "memory")
    private Float usedMemory;
    private String diff;

    public Task(){}

    public Task(String name, String PID, float usedMemory) {
        this.name = name;
        this.pid = PID;
        this.usedMemory = usedMemory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Float getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(Float usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", usedMemory=" + usedMemory +
                ", diff='" + diff + '\'' +
                '}';
    }
}
