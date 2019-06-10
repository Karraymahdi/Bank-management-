package hu.bme.model;

public class Customer {
	private String name;
	private String address;
	private String accountType;
	private String sex;
	private String idType;
	private String idNumber;
	private String dob;
	private String password;
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	private String accountNumber;
	private String image;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String address, String accountType, String sex, String idType, String idNumber,
			String dob, String password, String accountNumber, String image) {
		super();
		this.name = name;
		this.address = address;
		this.accountType = accountType;
		this.sex = sex;
		this.idType = idType;
		this.idNumber = idNumber;
		this.dob = dob;
		this.password = password;
		this.accountNumber = accountNumber;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		if (idNumber == null) {
			if (other.idNumber != null) {
				return false;
			}
		} else if (!idNumber.equals(other.idNumber)) {
			return false;
		}
		return true;
	}

}
