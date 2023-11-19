package Model;

public class Company {
    private String description;
    private String country;
    private String companyType;
    private String companyAddress;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "Company{" +
                "description='" + description + '\'' +
               // ", country='" + country + '\'' +
             //   ", companyType='" + companyType + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }
}
