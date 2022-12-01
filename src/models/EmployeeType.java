package models;

public enum EmployeeType {
    // Các phần tử này luôn là static final
    EXPERIENCE(1),
    FRESHER(2),
    INTERN(3);
    //(number: 0 || 1 || 2) là giá trị(value) number truyền vào, lấy ra theo phương thức .values
    private int choice;

    // Modifier của constructor enum luôn là private
    // Nếu không khai báo private, java cũng sẽ hiểu là private.
    // constructor này chỉ dùng trong nội bộ Enum
    EmployeeType(int type) {
        this.choice = type;
    }

    public int getType() {
        return choice;
    }

    public void setType(int type) {
        this.choice = type;
    }

    //viết một static method lấy ra WeekDay theo value.
    public static EmployeeType getEmplyeeType(int choice){
        for (EmployeeType employeeType : EmployeeType.values()){
            if (employeeType.choice == choice){
                return employeeType;
            }
        }
        return null;
    }

}
