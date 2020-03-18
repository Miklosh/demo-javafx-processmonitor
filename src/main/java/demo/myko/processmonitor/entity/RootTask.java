package demo.myko.processmonitor.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootTask {

    @XmlElement(name = "task")
    private Set<Task> taskSet;

    public RootTask() {}

    public RootTask(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }

    public Set<Task> getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }
}
