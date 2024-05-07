package io.thoughtscript.bootexample.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
    private long id;
    private String externalName;

    // TODO set company.
    private long companyFk;
    private Double glassdoorInterviewDifficulty;
    private String workOption;
    private String estimatedSalary;
    private String roleLocation;
    private String status;
    private String worktype;
    private String dateString;
    private String paySchedule;
    private String payType;
    private String actualSalary;
    private boolean benefits;
    private String internalName;

    public Role() {
    }

    public Role(long id, String externalName, long companyFk, Double glassdoorInterviewDifficulty, String workOption, String estimatedSalary, String roleLocation, String worktype, String dateString, String paySchedule,
                String payType, String actualSalary, boolean benefits, String internalName
    ) {
        this.id = id;
        this.externalName = externalName;
        this.companyFk = companyFk;
        this.glassdoorInterviewDifficulty = glassdoorInterviewDifficulty;
        this.workOption = workOption;
        this.estimatedSalary = estimatedSalary;
        this.roleLocation = roleLocation;
        this.worktype = worktype;
        this.dateString = dateString;
        this.paySchedule = paySchedule;
        this.payType = payType;
        this.actualSalary = actualSalary;
        this.benefits = benefits;
        this.internalName = internalName;
    }
}
