import javax.swing.ButtonGroup;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JRadioButton;

import javax.swing.JCheckBox;

import javax.swing.JTextArea;

import javax.swing.JTextField;

import javax.swing.JPanel;

import javax.swing.JComboBox;

import javax.swing.JScrollPane;

import javax.swing.BorderFactory;

import java.awt.Container;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.Color;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
class PizzaUI extends JFrame

{

    private static final long serialVersionUID = 1L;



    private JButton CalcPrice,AnotherOrder,NewCust,Exit;

    private JLabel PizzaSizeLabel,Toppings;

    private JRadioButton S,M,L;

    private JComboBox c1;

    private JCheckBox Mushroom,GreenPepper,Blackolives,Chicken,Onions,Bananapepper;

    private ButtonGroup group;

    private JLabel imageLabel,imageLabel2,imageLabel3;

    private JTextField NumberOfPizzasText;

    private JTextArea ta;

    private JScrollPane scrollPane;

    private JPanel pNorth, pSouth, pCenter, pSideText;

    private JPanel pSidePanel,pTopSide,pBotSide,pMidSide;



    private double grandTotal=0;

    ImageIcon image;

    private double price;

    private int toppingsCount,pizzaCount;

    private String toppingsList;

    private String pizzaSize;

    private String Crusttype ="none" ;



    public PizzaUI()

    {

        toppingsList="Regular";

        grandTotal=0;



        setDefaultCloseOperation(EXIT_ON_CLOSE);



        Container window=getContentPane();



        window.setLayout(new BorderLayout(10,10));

        NumberOfPizzasText=new JTextField("0",2);

        NumberOfPizzasText.setEditable(true);

        NumberOfPizzasText.setToolTipText("Number of Pizzas"); // an informative tool tip



        ta=new JTextArea("",20,20);

        ta.setEditable(false);



        scrollPane=new JScrollPane(ta);



        pNorth=new JPanel();

        pNorth.setLayout(new GridLayout(1,3));

        pCenter=new JPanel();

        pCenter.setLayout(new GridLayout(1,2));

        pTopSide=new JPanel();

        pTopSide.setLayout(new GridLayout(2,4));

        pTopSide.setBorder(BorderFactory.createMatteBorder(

                0, 0, 5, 0, Color.gray));

        pMidSide=new JPanel();

        pMidSide.setLayout(new GridLayout(7,1));

        pBotSide=new JPanel();

        pBotSide.setLayout(new GridLayout(1,4));

        pBotSide.setBorder(BorderFactory.createMatteBorder(

                5, 0, 0, 0, Color.gray));

        pSouth=new JPanel();

        pSouth.setLayout(new GridLayout(1,4));



        S=new JRadioButton("Thin");

        M=new JRadioButton("Regular");

        L=new JRadioButton("Deep-dish");

        String s1[] = { "Small", "Medium", "Large", "Super"};

        c1 = new JComboBox(s1);



        group=new ButtonGroup();

        group.add(S);

        group.add(M);

        group.add(L);


        imageLabel=new JLabel();

        imageLabel2=new JLabel();

        imageLabel3=new JLabel();



        image = new ImageIcon("image.jpeg");



        imageLabel.setIcon(image);

        imageLabel.setOpaque(true);

        imageLabel.setBackground(Color.WHITE);



        imageLabel2.setText("<html><FONT SIZE=14>Welcome to</FONT><br>" +

                "<FONT SIZE=14>Pizza House</FONT></html>");

        imageLabel2.setOpaque(true);

        imageLabel2.setBackground(Color.WHITE);



        imageLabel3.setIcon(image);

        imageLabel3.setOpaque(true);

        imageLabel3.setBackground(Color.WHITE);



        pNorth.add(imageLabel);

        pNorth.add(imageLabel2);

        pNorth.add(imageLabel3);



        pSideText=new JPanel();

        pSideText.setLayout(new GridLayout(1,1));

        pSideText.add(scrollPane);



        Toppings=new JLabel("Toppings:");

        GreenPepper=new JCheckBox("Green Pepper");

        Mushroom=new JCheckBox("Mushroom");

        Blackolives=new JCheckBox("Black Olives");

        Chicken=new JCheckBox("Chicken");

        Onions=new JCheckBox("Onions");

        Bananapepper = new JCheckBox("Banana Pepper");



        pMidSide.add(Toppings);

        pMidSide.add(GreenPepper);

        pMidSide.add(Mushroom);

        pMidSide.add(Blackolives);

        pMidSide.add(Chicken);

        pMidSide.add(Onions);

        pMidSide.add(Bananapepper);



        pBotSide.add(new JLabel("Number of Pizzas: "));

        pBotSide.add(NumberOfPizzasText);



        pTopSide.add(S);

        pTopSide.add(M);

        pTopSide.add(L);

        pTopSide.add(c1);



        pSidePanel=new JPanel();

        pSidePanel.setLayout(new BorderLayout(10,10));

        pSidePanel.add("North",pTopSide);

        pSidePanel.add("Center",pMidSide);

        pSidePanel.add("South",pBotSide);



        CalcPrice = new JButton("Calculate Price");

        AnotherOrder=new JButton("Order");

        NewCust=new JButton("Clear");

        Exit=new JButton("Quit");



        pSouth.add(CalcPrice);

        pSouth.add(AnotherOrder);

        pSouth.add(NewCust);

        pSouth.add(Exit);



        ClickAction handler=new ClickAction();

        CalcPrice.addActionListener(handler);

        NewCust.addActionListener(handler);

        AnotherOrder.addActionListener(handler);

        Exit.addActionListener(handler);



        pCenter.add(pSidePanel);



        pCenter.add(pSideText);



        window.add("North",pNorth);



        window.add("Center",pCenter);



        window.add("South",pSouth);

    }

    private class ClickAction implements ActionListener

    {

        public void actionPerformed(ActionEvent event)

        {



            if(event.getSource()==CalcPrice)

            {

                getCombobox();

                getRadioButton();

                getCheckedBoxes();

                try

                {



                    pizzaCount=Integer.valueOf(NumberOfPizzasText.getText());



                    if(pizzaCount<1)

                        throw new Exception();

                    else if(pizzaCount>0 && Crusttype != "none")

                    {

                        ta.append("Pizza Size: ");

                        ta.append(pizzaSize+"($"+price+")"+"\n");

                        ta.append("Pizza Crust: ");

                        ta.append(Crusttype);

                        ta.append("\nPrice of each Pizza: ");

                        if(toppingsCount>=1)

                        {

                            price+=toppingsCount;

                        }

                        ta.append(price+"\n");

                        ta.append("Number of Toppings: ");

                        ta.append(toppingsCount+"\n");

                        ta.append("Toppings: ");

                        ta.append(toppingsList+"\n");

                        ta.append("NumberOfPizzas: ");

                        ta.append(pizzaCount+"\n");

                        ta.append("SalesTax: ");

                        ta.append(((0.05*price*pizzaCount))+"\n");

                        ta.append("Total: ");



                        price=((0.05*price*pizzaCount)+price*pizzaCount);

                        ta.append(price+"\n\n");



                        grandTotal+=price;

                        ta.append("Grand Total: $");

                        ta.append(grandTotal+"\n\n");

                    }

                }

                catch(Exception e)

                {

                    JPanel warning=new JPanel();

                    JOptionPane.showMessageDialog

                            (warning,

                                    "Please Enter a Positive Integer more than 0 in the Number of Pizzas Field!!!",

                                    "Not a Integer Problem!!!",

                                    JOptionPane.ERROR_MESSAGE

                            );

                }



                group.clearSelection();

                GreenPepper.setSelected(false);

                Mushroom.setSelected(false);

                Blackolives.setSelected(false);

                Chicken.setSelected(false);

                Onions.setSelected(false);

                Bananapepper.setSelected(false);

                NumberOfPizzasText.setText("");

                c1.setSelectedIndex(0);

            }



            if(event.getSource()==Exit)

            {

                System.exit(0);

            }



            if(event.getSource()==AnotherOrder)

            {



                group.clearSelection();

                GreenPepper.setSelected(false);

                Mushroom.setSelected(false);

                Blackolives.setSelected(false);

                Chicken.setSelected(false);

                Onions.setSelected(false);

                Bananapepper.setSelected(false);

                NumberOfPizzasText.setText("");

                c1.setSelectedIndex(0);

            }



            if(event.getSource()==NewCust)

            {



                ta.setText("");

                grandTotal=0;

                group.clearSelection();

                GreenPepper.setSelected(false);

                Mushroom.setSelected(false);

                Blackolives.setSelected(false);

                Chicken.setSelected(false);

                Onions.setSelected(false);

                Bananapepper.setSelected(false);

                NumberOfPizzasText.setText("");

                c1.setSelectedIndex(0);

            }

        }

    }

    private void getCombobox(){



        price = 0.0;

        if(c1.getSelectedItem() == "Small"){

            pizzaSize="Small";

            price = 5.0;

        }else if(c1.getSelectedItem() == "Medium"){

            pizzaSize="Medium";

            price = 8.0;

        }else if(c1.getSelectedItem() == "Large"){

            pizzaSize="Medium";

            price = 12.0;

        }else if(c1.getSelectedItem() == "Super"){

            pizzaSize="Medium";

            price = 15.0;

        }

    }

    private void getRadioButton()

    {



        if(S.isSelected())

        {

            Crusttype = "Thin";

        }

        else if(M.isSelected())

        {

            Crusttype = "Regular";

        }

        else if(L.isSelected())

        {

            Crusttype = "Deep-dish";

        }

        else

        {

            JPanel warning=new JPanel();

            JOptionPane.showMessageDialog

                    (warning,

                            "Please Choose a Crust!!!\nFrom the RadioButtons!!!",

                            "You Didn't Choose a Crust!!!",

                            JOptionPane.ERROR_MESSAGE

                    );

        }

    }

    private void getCheckedBoxes()

    {

        toppingsCount=0;

        toppingsList="Regular";



        if(price==0.0)

        {

            JPanel warning=new JPanel();

            JOptionPane.showMessageDialog

                    (warning,

                            "Please Choose a Size!!!\nFrom the RadioButtons!!!",

                            "You Didn't Choose a Size!!!",

                            JOptionPane.ERROR_MESSAGE

                    );

        }



        else

        {

            if(GreenPepper.isSelected())

            {

                toppingsCount++;

                toppingsList=toppingsList+", Green Pepper";

            }

            if(Blackolives.isSelected())

            {

                toppingsCount++;

                toppingsList=toppingsList+", Blackolives";

            }

            if(Mushroom.isSelected())

            {

                toppingsCount++;

                toppingsList=toppingsList+", Mushroom";

            }

            if(Chicken.isSelected())

            {

                toppingsCount++;

                toppingsList=toppingsList+", Chicken";

            }

            if(Onions.isSelected())

            {

                toppingsCount++;

                toppingsList=toppingsList+", Onions";

            }

            if(Bananapepper.isSelected()){

                toppingsCount++;

                toppingsList = toppingsList + ", Banana Pepper";

            }

        }

    }

}