package AnimalShelterFinal;

import java.net.URL;
import java.util.ResourceBundle;

import AnimalShelterFinal.Animals.Animal;
import AnimalShelterFinal.Animals.Gender;
import AnimalShelterFinal.Products.Product;
import AnimalShelterFinal.Products.Webshop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class FXMLController implements Initializable {
    private Reservation reservations = new Reservation();
    private Webshop webshop = new Webshop();
    @FXML private ComboBox cmbSpecies;
    @FXML private RadioButton radMale;
    @FXML private TextField txtName;
    @FXML private TextField txtBadHabits;
    @FXML private ListView lstAnimals;
    @FXML private TextField txtReservor;
    @FXML private Button btn_Reserve;
    @FXML private ListView lstProducts;
    @FXML private TextField txtProductName;
    @FXML private Spinner numProductPrice;
    @FXML private Button btn_RemoveSelectedProduct;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set the combo box
        cmbSpecies.getItems().setAll("Cat", "Dog");
        cmbSpecies.getSelectionModel().select(0);

        // Set the spinner
        numProductPrice.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50));

        //Fill the products in the list view
        for (Product product:
            webshop.products) {
            lstProducts.getItems().add(product);
        }
    }

    public void btn_Reserve_Click(ActionEvent event) {
        Animal animal = (Animal)lstAnimals.getSelectionModel().getSelectedItem();

        if (animal != null)
        {
            animal.reserve(txtReservor.getText());
            this.refreshControls();
        }

        txtReservor.clear();
        this.refreshControls();
    }

    public void btn_AddAnimal_Click(ActionEvent event) {
        Gender gender;

        if (radMale.isSelected()){ gender = Gender.male; } else { gender = Gender.female; }

        if (this.cmbSpecies.getValue() == "Cat")
        {
            this.reservations.newCat(
                    txtName.getText(), gender, txtBadHabits.getText());
        }
        else if (this.cmbSpecies.getValue() == "Dog")
        {
            this.reservations.newDog(txtName.getText(), gender);
        }

        txtName.clear();
        txtBadHabits.clear();
        this.refreshControls();
    }

    public void btn_RemoveSelectedProduct_Click(ActionEvent event){
        webshop.removeProduct((Product)lstProducts.getSelectionModel().getSelectedItem());
        refreshControls();
    }

    public void btn_addProduct_Click(ActionEvent event){
        webshop.newProduct(txtProductName.getText(), (int)numProductPrice.getValue());
        refreshControls();
    }

    private void refreshControls() {
        lstAnimals.getItems().clear();
        for (Animal animal : this.reservations.Animals)
        {
            lstAnimals.getItems().add(animal);
        }

        lstProducts.getItems().clear();
        for (Product product : webshop.products) {
            lstProducts.getItems().add(product);
        }

        btn_Reserve.setDisable(lstAnimals.getSelectionModel().getSelectedItem() != null);
        btn_RemoveSelectedProduct.setDisable(lstProducts.getSelectionModel().getSelectedItem() != null);
    }
}
