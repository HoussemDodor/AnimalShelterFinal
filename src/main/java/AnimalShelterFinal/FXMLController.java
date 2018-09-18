package AnimalShelterFinal;

import java.net.URL;
import java.util.ResourceBundle;

import AnimalShelterFinal.Animals.Animal;
import AnimalShelterFinal.Animals.Gender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class FXMLController implements Initializable {
    private Reservation reservations = new Reservation();
    @FXML private ComboBox cmbSpecies;
    @FXML private RadioButton radMale;
    @FXML private TextField txtName;
    @FXML private TextField txtBadHabits;
    @FXML private ListView lstAnimals;
    @FXML private TextField txtReservor;
    @FXML private Button btn_Reserve;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbSpecies.getItems().setAll("Cat", "Dog");
        cmbSpecies.getSelectionModel().select(0);
    }

    public void btn_Reserve_Click(ActionEvent event) {

        Animal animal = (Animal)lstAnimals.getSelectionModel().getSelectedItem();

        if (animal != null)
        {
            animal.reserve(txtReservor.getText());
            this.RefreshControls();
        }

        txtReservor.clear();
        this.RefreshControls();
    }

    public void btn_AddAnimal_Click(ActionEvent event) {
        Gender gender;

        if (radMale.isSelected()){ gender = Gender.male; } else { gender = Gender.female; }

        if (this.cmbSpecies.getValue() == "Cat")
        {
            this.reservations.NewCat(
                    txtName.getText(), gender, txtBadHabits.getText());
        }
        else if (this.cmbSpecies.getValue() == "Dog")
        {
            this.reservations.NewDog(txtName.getText(), gender);
        }

        txtName.clear();
        txtBadHabits.clear();
        this.RefreshControls();
    }

    public void lstAnimals_SelectedIndexChanged(ActionEvent event) {

    }

    public void cmbSpecies_SelectedIndexChanged(ActionEvent event) {

    }

    private void RefreshControls() {
        lstAnimals.getItems().clear();
        for (Animal animal : this.reservations.Animals)
        {
            lstAnimals.getItems().add(animal);
        }

        btn_Reserve.setDisable(lstAnimals.getSelectionModel().getSelectedItem() != null);
    }

}
