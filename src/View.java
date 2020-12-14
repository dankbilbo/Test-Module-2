import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void menu() {
        while (true){
        System.out.println("--Chương trình quản lý danh bạ--");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("8.Thoát");
        System.out.println("Chọn chức năng : ");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                controller.showAll();
                break;
            case "2":
                controller.add();
                break;
            case "3":
                controller.update();
                break;
            case "4":
                controller.delete();
                break;
            case "5":
                controller.search();
                break;
            case "6":
                controller.docTuFile();
                break;
            case "7":
                controller.vietRaFile();
                break;
            case "8":
                System.exit(0);
            default:
                System.out.println("Nhập lại");
        }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
