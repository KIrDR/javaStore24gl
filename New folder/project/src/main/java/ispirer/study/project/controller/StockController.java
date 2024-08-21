package ispirer.study.project.controller;

import ispirer.study.project.model.Stock;
import ispirer.study.project.model.forms.Menu;
import ispirer.study.project.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class StockController {


    @PutMapping("/updateStockNumber")
    public ResponseEntity<String> updateStockNumber(@RequestBody StockRequest stockRequest) {
        if (stockRequest != null) {
            System.out.println("Received stockNumber: " + stockRequest.getStockNumber());
            System.out.println("Received manuCode: " + stockRequest.getManuCode());
            Menu.setStockId(stockRequest.getStockNumber());
            Menu.setStockManu(stockRequest.getManuCode());
        }

        return ResponseEntity.ok("Stock number updated successfully");
    }

    public static class StockRequest {
        private int stockNumber;
        private String manuCode;

        public int getStockNumber() {
            return stockNumber;
        }

        public void setStockNumber(int stockNumber) {
            this.stockNumber = stockNumber;
        }

        public String getManuCode() {
            return manuCode;
        }

        public void setManuCode(String manuCode) {
            this.manuCode = manuCode;
        }
    }
}
