package uts.isd.model;

import java.util.Date;
import java.util.List;

public class Order {
    private Long id;
    private List<Product> productList;
    private String name;
    private String contactNum;
    private String address;
    private Double totalSum;
    private String createTime;
    private Integer state;

    public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	@Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productList=" + productList +
                ", name='" + name + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", address='" + address + '\'' +
                ", totalSum=" + totalSum +
                '}';
    }
    

    public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

