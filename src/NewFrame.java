import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewFrame extends JFrame {
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int id = -1;
    int number = -1;
    int hotelid=-1;
    int resnum=-1;
    JPanel upPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel downPanel = new JPanel();
    JPanel RoomUpPanel = new JPanel();
    JPanel RoomMidPanel = new JPanel();
    JPanel RoomDownPanel = new JPanel();
    JPanel HotelUpPanel = new JPanel();
    JPanel HotelMidPanel = new JPanel();
    JPanel HotelDownPanel = new JPanel();
    JPanel ResUpPanel = new JPanel();
    JPanel ResMidPanel = new JPanel();
    JPanel ResDownPanel = new JPanel();
    JLabel fnameL = new JLabel("Name");
    JLabel lnameL = new JLabel("LastName");
    JLabel sexL = new JLabel("Sex");
    JLabel ageL = new JLabel("Age");
    JLabel salaryL = new JLabel("Salary");
    JTextField fnameT = new JTextField();
    JTextField lnameT = new JTextField();
    JTextField ageT = new JTextField();
    JTextField salaryT = new JTextField();
    String[] item = {"Male", "Female"};
    JComboBox<String> sexCombo = new JComboBox<String>(item);
    JComboBox<String> personCombo=new JComboBox<String>();
    JLabel roomstayL = new JLabel("Staying at room number:");
    JComboBox<String> RoomStayCombo=new JComboBox<String>( );
    JLabel hotelstayL = new JLabel("Staying at hotel:");
    JComboBox<String> HotelStayCombo=new JComboBox<String>();
    //room
    JLabel occupantsL = new JLabel("Occupants");
    JLabel typeL = new JLabel("Type");
    JLabel bookedL = new JLabel("Booked");
    JLabel rentL = new JLabel("Rent");
    JTextField occupantsT = new JTextField();
    String[] roombooked = {"Yes", "No"};
    JComboBox<String> BookedCombo = new JComboBox<String>(roombooked);
    //JComboBox<String> BookedCombo = new JComboBox<String>(roombooked);
    String[] roomitemtype = {"Luxury", "Standard"};
    JComboBox<String> TypeCombo = new JComboBox<String>(roomitemtype);
    //JComboBox<String> resCombo=new JComboBox<String>();
    JTextField rentT = new JTextField();
    JComboBox<String> RoomCombo=new JComboBox<String>();
    JLabel occupantL = new JLabel("Staying at room:");
    JComboBox<String> OccupantCombo=new JComboBox<String>( );
    JLabel hotelroomL = new JLabel("Hotel:");
    JComboBox<String> HotelRoomCombo=new JComboBox<String>();
    //room
    //hotel
    JLabel hotelidL = new JLabel("Hotel Name:");
    JLabel addressL = new JLabel("Address");
    JLabel starsL = new JLabel("Stars");
    JLabel floorsL = new JLabel("Floors");
    JLabel appearedL = new JLabel("Previously reserved:");
    JComboBox<String> AppearedCombo=new JComboBox<String>();
    JTextField addressT = new JTextField();
    JTextField hotelidT = new JTextField();
    String[] stars = {"1", "2", "3", "4", "5"};
    JComboBox<String> StarsCombo = new JComboBox<String>(stars);
    JTextField floorsT = new JTextField();
    JComboBox<String> HotelCombo=new JComboBox<String>();
    //hotel
    //res
    JLabel hotelL = new JLabel("Hotel");
    JLabel numberL = new JLabel("Room Number");
    JLabel personL = new JLabel("Person");
    JComboBox<String> ResCombo=new JComboBox<String>();
    JComboBox<String> HotelResCombo=new JComboBox<String>();
    JComboBox<String> NumberResCombo=new JComboBox<String>();
    JComboBox<String> PersonResCombo=new JComboBox<String>();
    //res
    JButton addB = new JButton("Add");
    JButton delB = new JButton("Delete");
    JButton ediB = new JButton("Ëdit");
    JButton serB= new JButton("Search");
    JButton refB = new JButton("Refresh");
    JTable table = new JTable();
    JScrollPane scroll = new JScrollPane(table);
    //room
    JButton raddB = new JButton("Add");
    JButton rdelB = new JButton("Delete");
    JButton rediB = new JButton("Ëdit");
    JButton rserB= new JButton("Search");
    JButton rrefB = new JButton("Refresh");
    JTable rtable=new JTable();
    JScrollPane rscroll = new JScrollPane(rtable);
    //room
    //hotel
    JButton haddB = new JButton("Add");
    JButton hdelB = new JButton("Delete");
    JButton hediB = new JButton("Ëdit");
    JButton hserB= new JButton("Search");
    JButton hrefB = new JButton("Refresh");
    JTable htable=new JTable();
    JScrollPane hscroll = new JScrollPane(htable);
    //hotel
    //res
    JButton resB = new JButton("Reserve");
    JButton redelB = new JButton("Delete");
    JButton reediB = new JButton("Ëdit");
    JButton reserB= new JButton("Search");
    JButton rerefB = new JButton("Refresh");
    JTable retable=new JTable();
    JScrollPane rescroll = new JScrollPane(retable);
    //res
    JPanel personP=new JPanel();
    JPanel hotelP=new JPanel();
    JPanel roomP=new JPanel();
    JPanel reserveP=new JPanel();
    JTabbedPane tab=new JTabbedPane();
    public NewFrame() {
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(tab);
        tab.add(personP,"Person");
        tab.add(hotelP,"Hotel");
        tab.add(roomP,"Room");
        tab.add(reserveP,"Reservation");
        upPanel.setLayout(new GridLayout(7, 3));
        upPanel.add(fnameL);
        upPanel.add(fnameT);
        upPanel.add(lnameL);
        upPanel.add(lnameT);
        upPanel.add(sexL);
        upPanel.add(sexCombo);
        upPanel.add(ageL);
        upPanel.add(ageT);
        upPanel.add(salaryL);
        upPanel.add(salaryT);
        upPanel.add(roomstayL);
        upPanel.add(RoomStayCombo);
        upPanel.add(hotelstayL);
        upPanel.add(HotelStayCombo);
        personP.add(upPanel);
        //room
        RoomUpPanel.setLayout(new GridLayout(7, 3));
        RoomUpPanel.add(occupantsL);
        RoomUpPanel.add(occupantsT);
        RoomUpPanel.add(typeL);
        RoomUpPanel.add(TypeCombo);
        RoomUpPanel.add(bookedL);
        RoomUpPanel.add(BookedCombo);
        RoomUpPanel.add(rentL);
        RoomUpPanel.add(rentT);
        RoomUpPanel.add(occupantL);
        RoomUpPanel.add(OccupantCombo);
        RoomUpPanel.add(hotelroomL);
        RoomUpPanel.add(HotelRoomCombo);
        RoomUpPanel.add(AppearedCombo);
        roomP.add(RoomUpPanel);
        //room
        //hotel
        HotelUpPanel.setLayout(new GridLayout(4, 1));
        HotelUpPanel.add(hotelidL);
        HotelUpPanel.add(hotelidT);
        HotelUpPanel.add(addressL);
        HotelUpPanel.add(addressT);;
        HotelUpPanel.add(starsL);
        HotelUpPanel.add(StarsCombo);
        HotelUpPanel.add(floorsL);
        HotelUpPanel.add(floorsT);
        //HotelUpPanel.add(appearedL);
        //HotelUpPanel.add(AppearedCombo);
        hotelP.add(HotelUpPanel);
        //hotel
        //res
        ResUpPanel.setLayout(new GridLayout(5, 2));
        ResUpPanel.add(hotelL);
        ResUpPanel.add(HotelResCombo);
        ResUpPanel.add(numberL);
        ResUpPanel.add(NumberResCombo);
        ResUpPanel.add(personL);
        ResUpPanel.add(PersonResCombo);
        reserveP.add(ResUpPanel);
        //res
        //MidPanel
        midPanel.add(addB);
        midPanel.add(delB);
        midPanel.add(ediB);
        midPanel.add(serB);
        midPanel.add(refB);
        midPanel.add(personCombo);
        personP.add(midPanel);
        //room mid
        RoomMidPanel.add(raddB);
        RoomMidPanel.add(rdelB);
        RoomMidPanel.add(rediB);
        RoomMidPanel.add(rserB);
        RoomMidPanel.add(rrefB);
        RoomMidPanel.add(RoomCombo);
        roomP.add(RoomMidPanel);
        //room
        //hotel mid
        HotelMidPanel.add(haddB);
        HotelMidPanel.add(hdelB);
        HotelMidPanel.add(hediB);
        HotelMidPanel.add(hserB);
        HotelMidPanel.add(hrefB);
        HotelMidPanel.add(HotelCombo);
        hotelP.add(HotelMidPanel);
        //hotel
        //res
        ResMidPanel.add(resB);
        ResMidPanel.add(redelB);
        ResMidPanel.add(reediB);
        ResMidPanel.add(reserB);
        ResMidPanel.add(rerefB);
        ResMidPanel.add(ResCombo);
        reserveP.add(ResMidPanel);
        //res
        //DownPanel
        scroll.setPreferredSize(new Dimension(350, 150));
        downPanel.add(scroll);
        addB.addActionListener(new NewFrame.AddAction());
        table.addMouseListener(new NewFrame.MouseAction());
        raddB.addActionListener(new NewFrame.RoomAddAction());
        rtable.addMouseListener(new NewFrame.RoomMouseAction());
        refreshTable();
        refreshComboPerson();
        refreshComboRoomStay();
        refreshComboHotelStay();
        refreshComboOccupant();
        refreshComboHotelRoom();
        refreshHotelCombo();
        refreshNumberCombo();
        refreshPersonCombo();
        RoomRefreshTable();
        //refreshComboBooked();
        RoomRefreshComboType();
        this.setVisible(true);
        personP.add(downPanel);
        //room down
        RoomDownPanel.add(rscroll);
        roomP.add(RoomDownPanel);
        delB.addActionListener(new NewFrame.DeleteAction());
        ediB.addActionListener(new NewFrame.EditAction());
        serB.addActionListener(new NewFrame.SearchAction());
        refB.addActionListener(new NewFrame.RefreshAction());
        rdelB.addActionListener(new NewFrame.RoomDeleteAction());
        rediB.addActionListener(new NewFrame.RoomEditAction());
        rserB.addActionListener(new NewFrame.RoomSearchAction());
        rrefB.addActionListener(new NewFrame.RoomRefreshAction());
        //room
        //hotel down
        HotelDownPanel.add(hscroll);
        haddB.addActionListener(new NewFrame.HotelAddAction());
        htable.addMouseListener(new NewFrame.HotelMouseAction());
        //HotelRefreshComboStars();
        HotelRefreshComboAppeared();
        HotelRefreshTable();
        hdelB.addActionListener(new NewFrame.HotelDeleteAction());
        hediB.addActionListener(new NewFrame.HotelEditAction());
        hserB.addActionListener(new NewFrame.HotelSearchAction());
        hrefB.addActionListener(new NewFrame.HotelRefreshAction());
        hotelP.add(HotelDownPanel);
        //hotel
        //res
        ResDownPanel.add(rescroll);
        resB.addActionListener(new NewFrame.ResAddAction());
        retable.addMouseListener(new NewFrame.ResMouseAction());
        ReserveRefreshTable();
        redelB.addActionListener(new NewFrame.ResDeleteAction());
        reediB.addActionListener(new NewFrame.ResEditAction());
        reserB.addActionListener(new NewFrame.ResSearchAction());
        rerefB.addActionListener(new NewFrame.ReserveRefreshAction());
        reserveP.add(ResDownPanel);
        //res
        this.setVisible(true);
    }
    public void refreshTable() {
        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("select * from person");
            result = state.executeQuery();
            table.setModel(new MyModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void refreshComboPerson(){
        String sql="select id, fname, lname from person";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            personCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString()+"."+result.getObject(2).toString()+" "+result.getObject(3).toString();
                personCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void refreshComboHotelStay() {
        //display in HotelStayCombo, hotel from room, but take into consideration the text from fnameT and lnameT
        String sql = "select distinct hotel from room";
        conn = DBConnection.getConnection();
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            HotelStayCombo.removeAllItems();
            while (result.next()) {
                item = result.getObject(1).toString();
                HotelStayCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void refreshComboRoomStay(){
        //select number from room
        String sql="select distinct number from room";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            RoomStayCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString();
                RoomStayCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void clearForm() {
        fnameT.setText("");
        lnameT.setText("");
        sexCombo.setSelectedIndex(0);
        RoomStayCombo.setSelectedIndex(0);
        HotelStayCombo.setSelectedIndex(0);
        ageT.setText("");
        salaryT.setText("");
    }
    class AddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "Insert into person(fname,lname,sex,age,salary)" + "values(?,?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, fnameT.getText());
                state.setString(2, lnameT.getText());
                state.setString(3, sexCombo.getSelectedItem().toString());
                state.setInt(4, Integer.parseInt(ageT.getText()));
                state.setFloat(5, Float.parseFloat(salaryT.getText()));
                //state.setString(6, HotelStayCombo.getSelectedItem().toString());
                //state.setString(7, RoomStayCombo.getSelectedItem().toString());
                state.execute();
                refreshTable();
                refreshComboPerson();
                refreshComboRoomStay();
                refreshComboHotelStay();
                clearForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class UpdateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "Update person set fname=?,lname=?,sexCombo=?,age=?,salary=?, room=?, hotel=?" + "where id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, fnameT.getText());
                state.setString(2, lnameT.getText());
                state.setString(3, sexCombo.getSelectedItem().toString());
                state.setInt(4, Integer.parseInt(ageT.getText()));
                state.setFloat(5, Float.parseFloat(salaryT.getText()));
                state.setInt(6, Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));

                state.execute();
                refreshTable();
                clearForm();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            id = Integer.parseInt(table.getValueAt(row, 0).toString());
            fnameT.setText(table.getValueAt(row, 1).toString());
            lnameT.setText(table.getValueAt(row, 2).toString());
            if (table.getValueAt(row, 3).toString().equals("Male")) {
                sexCombo.setSelectedIndex(0);
            } else {
                sexCombo.setSelectedIndex(1);
            }
            ageT.setText(table.getValueAt(row, 4).toString());
            salaryT.setText(table.getValueAt(row, 5).toString());
            HotelStayCombo.setSelectedItem(table.getValueAt(row,6).toString());
            RoomStayCombo.setSelectedItem(table.getValueAt(row,7).toString());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class DeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "delete from person where id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, id);
                state.execute();
                refreshTable();
                clearForm();
                id = -1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class EditAction implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {


            conn = DBConnection.getConnection();
            String sql = "update person set fname =?, lname=?, sex=?, age=?, salary=? where id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1,fnameT.getText());
                state.setString(2,lnameT.getText());
                state.setString(3,sexCombo.getSelectedItem().toString());
                state.setInt(4,Integer.parseInt(ageT.getText()));
                state.setFloat(5,Float.parseFloat(salaryT.getText()));
                state.setInt(6,id);



                state.execute();
                clearForm();
                refreshTable();
                //System.out();_
            }catch(SQLException s) {
                s.printStackTrace();
            }


        }
    }
    class SearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "select * from person where fname like '%" + fnameT.getText() + "%'";
            try {
                state = conn.prepareStatement(sql);
                result = state.executeQuery();
                table.setModel(new MyModel(result));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    //room
    public void RoomRefreshTable() {
        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("select * from room");
            result = state.executeQuery();
            rtable.setModel(new MyModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void RoomRefreshComboType(){
        String sql="select occupants, type, isbooked from room";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            RoomCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString()+"."+result.getObject(2).toString()+" "+result.getObject(3).toString();
                RoomCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void RefreshComboBooked(){
        String sql="select occupants, type, isbooked from room";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            BookedCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString()+"."+result.getObject(2).toString()+" "+result.getObject(3).toString();
                BookedCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void refreshComboOccupant() {
        //select occupant from room where occupant=id from room
        String sql = "select person from reservation";
        conn = DBConnection.getConnection();
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            OccupantCombo.removeAllItems();
            while (result.next()) {
                item = result.getObject(1).toString();
                OccupantCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void refreshComboHotelRoom(){
        String sql="select id from hotel";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            HotelRoomCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString();
                HotelRoomCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void RoomClearForm() {
        occupantsT.setText("");
        TypeCombo.setSelectedIndex(0);
        BookedCombo.setSelectedIndex(0);
        rentT.setText("");
        OccupantCombo.setSelectedIndex(0);
        HotelRoomCombo.setSelectedIndex(0);
    }
    class RoomAddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "insert into room(occupants,type,isbooked,rent,occupant,hotel)" + "values(?,?,?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, occupantsT.getText());
                state.setString(2, TypeCombo.getSelectedItem().toString());
                state.setString(3, BookedCombo.getSelectedItem().toString());
                state.setFloat(4, Float.parseFloat(rentT.getText()));
                String occupant = OccupantCombo.getSelectedItem().toString();
                String[] occupantId = occupant.split("\\.");
                state.setString(5, occupantId[0]);
                state.setString(6, HotelRoomCombo.getSelectedItem().toString());
                state.execute();
                RoomRefreshTable();
                //refreshComboBooked();
                refreshComboOccupant();
                refreshComboHotelRoom();
                RoomRefreshComboType();
                refreshComboHotelRoom();
                RoomClearForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class RoomUpdateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "Update room set occupants=?,type=?,isbooked=?,rent=?,occupant=?,hotel=?" + "where number=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, occupantsT.getText());
                state.setString(2, TypeCombo.getSelectedItem().toString());
                state.setString(3, BookedCombo.getSelectedItem().toString());
                state.setFloat(4, Float.parseFloat(rentT.getText()));
                state.setString(5, OccupantCombo.getSelectedItem().toString());
                state.setString(6, HotelRoomCombo.getSelectedItem().toString());
                state.execute();
                RoomRefreshTable();
                clearForm();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class RoomMouseAction extends JFrame implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = rtable.getSelectedRow();
            number = Integer.parseInt(rtable.getValueAt(row, 0).toString());
            occupantsT.setText(rtable.getValueAt(row, 1).toString());
            if (rtable.getValueAt(row, 2).toString().equals("Luxury")) {
                TypeCombo.setSelectedIndex(0);
            } else {
                TypeCombo.setSelectedIndex(1);
            }
            if (rtable.getValueAt(row, 3).toString().equals("Yes")) {
                BookedCombo.setSelectedIndex(0);
                RoomUpPanel.add(ResCombo);
            } else {
                BookedCombo.setSelectedIndex(1);
            }
            rentT.setText(rtable.getValueAt(row, 4).toString());
            OccupantCombo.setSelectedItem(rtable.getValueAt(row,5).toString());
            HotelRoomCombo.setSelectedItem(rtable.getValueAt(row,6).toString());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class RoomDeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "delete from room where number=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, number);
                state.execute();
                RoomRefreshTable();
                RoomClearForm();
                number = -1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class RoomEditAction implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {


            conn = DBConnection.getConnection();
            String sql = "Update room set occupants=?,type=?,isbooked=?,rent=?,occupant=?,hotel=?" + "where number=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, occupantsT.getText());
                state.setString(2, TypeCombo.getSelectedItem().toString());
                state.setString(3, BookedCombo.getSelectedItem().toString());
                state.setFloat(4, Float.parseFloat(rentT.getText()));
                state.setString(5, OccupantCombo.getSelectedItem().toString());
                state.setString(6, HotelRoomCombo.getSelectedItem().toString());
                state.setInt(7, number);
                //state.setInt(7,number);
                state.execute();
                RoomClearForm();
                RoomRefreshTable();
                //System.out();_
            }catch(SQLException s) {
                s.printStackTrace();
            }


        }
    }
    class RoomSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "select * from room where occupants like '%" + occupantsT.getText() + "%'";
            try {
                state = conn.prepareStatement(sql);
                result = state.executeQuery();
                rtable.setModel(new MyModel(result));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    //hotel functions
    public void HotelRefreshTable() {
        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("select * from hotel");
            result = state.executeQuery();
            htable.setModel(new MyModel(result));
            refreshComboHotelRoom();
            refreshHotelCombo();
            refreshComboHotelStay();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void HotelRefreshComboStars(){
        String sql="select address, stars, floors from hotel";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            HotelCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString()+"."+result.getObject(2).toString()+" "+result.getObject(3).toString();
                HotelCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void HotelRefreshComboAppeared() {
        //select person staying in room and how many times previously reserved room
        /*String sql = "select distinct occupant, count(*) from room group by occupant";
        conn = DBConnection.getConnection();
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            AppearedCombo.removeAllItems();
            while (result.next()) {
                item = result.getObject(1).toString() + "." + result.getObject(2).toString();
                AppearedCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        //select person staying in room and room number and hotel and how many times previously reserved room
        String sql = "select distinct occupant, number, hotel, count(*) from room group by occupant, number, hotel";
        conn = DBConnection.getConnection();
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            AppearedCombo.removeAllItems();
            while (result.next()) {
                item = result.getObject(1).toString() + "." + result.getObject(2).toString() + "." + result.getObject(3).toString() + "." + result.getObject(4).toString();
                AppearedCombo.addItem(item);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //select occupant and link to person, where id is occupant
        String sql2 = "select id,fname,lname from person where id in (select distinct occupant from room)";
        conn = DBConnection.getConnection();
        String item2 = "";
        try {
            state = conn.prepareStatement(sql2);
            result = state.executeQuery();
            //AppearedCombo.removeAllItems();
            while (result.next()) {
                item2 = result.getObject(1).toString()+" "+result.getObject(2).toString()+" "+result.getObject(3).toString();
                AppearedCombo.addItem(item2);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void HotelClearForm() {
        hotelidT.setText("");
        addressT.setText("");
        StarsCombo.setSelectedIndex(0);
        AppearedCombo.setSelectedIndex(0);
        floorsT.setText("");
    }
    class HotelAddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "Insert into hotel(id,address,stars,floors)" + "values(?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, hotelidT.getText());
                state.setString(2, addressT.getText());
                state.setString(3, StarsCombo.getSelectedItem().toString());
                state.setFloat(4, Float.parseFloat(floorsT.getText()));
                state.execute();
                HotelRefreshTable();
                //refreshComboBooked();
                HotelRefreshComboStars();
                HotelRefreshComboAppeared();
                HotelClearForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class HotelUpdateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "Update hotel set id=?,address=?,stars=?,floors=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, hotelidT.getText());
                state.setString(2, addressT.getText());
                state.setString(3, StarsCombo.getSelectedItem().toString());
                state.setFloat(4, Float.parseFloat(floorsT.getText()));
                state.execute();
                HotelRefreshTable();
                HotelClearForm();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class HotelMouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = htable.getSelectedRow();
            hotelidT.setText(htable.getValueAt(row, 0).toString());
            addressT.setText(htable.getValueAt(row, 1).toString());
            if (htable.getValueAt(row, 2).toString().equals("1")) {
                StarsCombo.setSelectedIndex(0);
            }
            else if (htable.getValueAt(row, 2).toString().equals("2")) {
                StarsCombo.setSelectedIndex(1);
            }
            else if (htable.getValueAt(row, 2).toString().equals("3")) {
                StarsCombo.setSelectedIndex(2);
            }
            else if (htable.getValueAt(row, 2).toString().equals("4")) {
                StarsCombo.setSelectedIndex(3);
            }
            else {
                StarsCombo.setSelectedIndex(4);
            }
            floorsT.setText(htable.getValueAt(row, 3).toString());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class HotelDeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            //delete hotel and its reservations and rooms
            String sql = "Delete from hotel where id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, hotelidT.getText());
                state.execute();
                HotelRefreshTable();
                HotelClearForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //delete reservations
            conn = DBConnection.getConnection();
            sql = "Delete from reservation where hotel=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, hotelidT.getText());
                state.execute();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            //delete rooms
            conn = DBConnection.getConnection();
            sql = "Delete from room where hotel=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, hotelidT.getText());
                state.execute();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class HotelEditAction implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {


            conn = DBConnection.getConnection();
            String sql = "update hotel set id=?, address=?, stars=?, floors=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, hotelidT.getText());
                state.setString(2, addressT.getText());
                state.setString(3, StarsCombo.getSelectedItem().toString());
                state.setFloat(4, Float.parseFloat(floorsT.getText()));
                state.execute();
                HotelClearForm();
                HotelRefreshTable();
                //System.out();_
            }catch(SQLException s) {
                s.printStackTrace();
            }


        }
    }
    class HotelSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "select * from hotel where id like '%" + hotelidT.getText() + "%'";
            try {
                state = conn.prepareStatement(sql);
                result = state.executeQuery();
                htable.setModel(new MyModel(result));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    //hotel
    //res
    public void ReserveRefreshTable() {
        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("select * from reservation");
            result = state.executeQuery();
            retable.setModel(new MyModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void refreshHotelCombo() {
        String sql="select id from hotel";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            HotelResCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString();
                HotelResCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void refreshNumberCombo() {
        String sql="select number from room";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            NumberResCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString();
                NumberResCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void refreshPersonCombo() {
        //select person from reservation
        String sql="select id,fname,lname from person";

        //String sql="select id,fname,lname from person where id='%"+PersonResCombo.getSelectedItem().toString()+"%'";
        conn=DBConnection.getConnection();
        String item="";
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            PersonResCombo.removeAllItems();
            while(result.next()){
                item=result.getObject(1).toString()+" "+result.getObject(2).toString()+" "+result.getObject(3).toString();
                //item=result.getObject(1).toString();
                PersonResCombo.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ResClearForm() {
        addressT.setText("");
        StarsCombo.setSelectedIndex(0);
        floorsT.setText("");
        HotelResCombo.setSelectedIndex(0);
        NumberResCombo.setSelectedIndex(0);
        PersonResCombo.setSelectedIndex(0);
    }
    class ResAddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //update hotel and room in table person
            String sql="update person set hotel=?,room=? where id=?";
            conn=DBConnection.getConnection();
            try {
                state=conn.prepareStatement(sql);
                state.setString(1,HotelResCombo.getSelectedItem().toString());
                state.setString(2,NumberResCombo.getSelectedItem().toString());
                //split id
                String[] id=PersonResCombo.getSelectedItem().toString().split(" ");
                state.setString(3,id[0]);
                state.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //update reservation
            conn = DBConnection.getConnection();
            String sql2 = "Insert into reservation(person,room,hotel)" + "values(?,?,?)";
            try {
                state = conn.prepareStatement(sql2);
                //get the first three values from PersonResCombo
                String[] parts = PersonResCombo.getSelectedItem().toString().split(" ");
                String id = parts[0];
                state.setString(1, id);
                state.setString(2, NumberResCombo.getSelectedItem().toString());
                state.setString(3, HotelResCombo.getSelectedItem().toString());
                state.execute();
                ReserveRefreshTable();
                //refreshComboBooked();
                ResClearForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class ResUpdateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "Update reservation set person=?,room=?,hotel=?" + "where num=?";
            try {
                state = conn.prepareStatement(sql);
                //split PersonResCombo to get id
                String[] parts = PersonResCombo.getSelectedItem().toString().split(" ");
                String id = parts[0];
                state.setString(1, id);
                state.setString(2, NumberResCombo.getSelectedItem().toString());
                state.setString(3, HotelResCombo.getSelectedItem().toString());
                state.execute();
                ReserveRefreshTable();
                ResClearForm();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class ResMouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = retable.getSelectedRow();
            resnum = Integer.parseInt(retable.getValueAt(row, 0).toString());
            //get first three digits of id from person and display in PersonResCombo
            String[] parts = retable.getValueAt(row, 1).toString().split(" ");
            String id = parts[0];
            PersonResCombo.setSelectedItem(id);
            //PersonResCombo.setSelectedItem(retable.getValueAt(row, 1).toString());
            NumberResCombo.setSelectedItem(retable.getValueAt(row, 2).toString());
            HotelResCombo.setSelectedItem(retable.getValueAt(row, 3).toString());
        }
        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class ResDeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "delete from reservation where num=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, resnum);
                state.execute();
                ReserveRefreshTable();
                ResClearForm();
                resnum = -1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class ResEditAction implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {


            conn = DBConnection.getConnection();
            String sql = "update reservation set person=?, room=?, hotel=? where id=?";
            try {
                System.out.println(id+"\n"+sql);
                state = conn.prepareStatement(sql);
                //split PersonResCombo to get id
                String[] parts = PersonResCombo.getSelectedItem().toString().split(" ");
                String id = parts[0];
                state.setString(1, id);
                state.setString(2, NumberResCombo.getSelectedItem().toString());
                state.setString(3, HotelResCombo.getSelectedItem().toString());
                state.setInt(4, resnum);
                state.execute();
                ResClearForm();
                ReserveRefreshTable();
                //System.out();_
            }catch(SQLException s) {
                s.printStackTrace();
            }


        }
    }
    class ResSearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "select * from reservation where person=? or room=? or hotel=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, PersonResCombo.getSelectedItem().toString());
                state.setString(2, NumberResCombo.getSelectedItem().toString());
                state.setString(3, HotelResCombo.getSelectedItem().toString());
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //res
    class RefreshAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTable();
        }
    }
    class RoomRefreshAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            RoomRefreshTable();
        }
    }
    class HotelRefreshAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HotelRefreshTable();
        }
    }
    class ReserveRefreshAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ReserveRefreshTable();
        }
    }
    class NewAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //open new frame
            new NewFrame();
        }
    }
}