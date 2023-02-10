/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TRAN DUC HIEU
 */
public class Topic {

    private int topicId;
    private String topicName;
    private String topicDes;
    private int topicOrder;

    public Topic(int topicId, String topicName, String topicDes, int topicOrder) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicDes = topicDes;
        this.topicOrder = topicOrder;
    }

    public Topic() {
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDes() {
        return topicDes;
    }

    public void setTopicDes(String topicDes) {
        this.topicDes = topicDes;
    }

    public int getTopicOrder() {
        return topicOrder;
    }

    public void setTopicOrder(int topicOrder) {
        this.topicOrder = topicOrder;
    }

    @Override
    public String toString() {
        return "Topic{" + "topicId=" + topicId + ", topicName=" + topicName + ", topicDes=" + topicDes + ", topicOrder=" + topicOrder + '}';
    }

}
