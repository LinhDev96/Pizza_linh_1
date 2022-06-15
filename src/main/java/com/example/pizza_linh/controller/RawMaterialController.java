package com.example.pizza_linh.controller;

import com.example.pizza_linh.model.RawMaterial;
import com.example.pizza_linh.model.ResponseObject;
import com.example.pizza_linh.service.IRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/RawMaterial")
public class RawMaterialController {

    @Autowired
    private IRawMaterialService iRawMaterialService;

    @GetMapping("/findAll")
    public ResponseEntity<ResponseObject> findAllRawMaterial() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query product successfully ", iRawMaterialService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findAllRawMaterialById(@PathVariable Integer id) {
        Optional<RawMaterial> rawMaterial = iRawMaterialService.findById(id);
        if (rawMaterial.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "find raw material by id successfully", rawMaterial)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("error", "find raw material by id fail", null)
            );
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertRawMaterial(@RequestBody RawMaterial newRawMaterial) {
        Optional<RawMaterial> rawMaterial = iRawMaterialService.findByName(newRawMaterial.getName().trim());//ham trim de
        //dung de xoa khoang trang hai dau cua string
        if (rawMaterial.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "rawmaterial already have", "")
            );
        } else {
            iRawMaterialService.insert(newRawMaterial);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "insert raw material successfully", newRawMaterial));
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ResponseObject> updateRawMaterial(@RequestBody RawMaterial newRawMaterial, @PathVariable Integer id) {
//        RawMaterial updatedRawMaterial = iRawMaterialService.findById(id).map(
//                oldProduct -> {// th tim bang id va thay trung nhau nen ghi de
////                    oldProduct.setProductCode(newRawMaterial.getProductCode());
//                    oldProduct.setName(newRawMaterial.getName());
//                    oldProduct.setBarcode(newRawMaterial.getBarcode());
//                    oldProduct.setQuantity(newRawMaterial.getQuantity());
//                    oldProduct.setPrice(newRawMaterial.getPrice());
//                    oldProduct.setSupplier(newRawMaterial.getSupplier());
//                    return iRawMaterialService.save(oldProduct);
//                }
//        ).orElseGet(() -> {//th khong trung thi insert moi
//            return null;
////            return iRawMaterialService.save(newRawMaterial);
//        });
//        if(updatedRawMaterial==null){
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("fail", "there is no raw material, please create first", ""));
//        }else{
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("ok", "update raw material successfully", updatedRawMaterial));
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateRawMaterialv2(@RequestBody RawMaterial newRawMaterial, @PathVariable Integer id) {
        Optional<RawMaterial> RawMaterial = iRawMaterialService.findById(id);//tim bang id truoc
        if (RawMaterial.isPresent()&&RawMaterial.get().equals(newRawMaterial)) {//ham equal nay da duoc ghi de
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("fail", "already exist,no update has been done", ""));
        }else if(RawMaterial.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("fail", "there is no raw material, please create first", ""));
        }else{
            RawMaterial.map(oldOne ->{//lay gia tri cua cai moi ghi de len cai cu
               oldOne.setQuantity(newRawMaterial.getQuantity());
               oldOne.setSupplier(newRawMaterial.getSupplier());
               oldOne.setName(newRawMaterial.getName());
               oldOne.setPrice(newRawMaterial.getPrice());
               oldOne.setBarcode(newRawMaterial.getBarcode());
               oldOne.setFbStatus(newRawMaterial.getFbStatus());
               return iRawMaterialService.save(oldOne);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update raw material successfully", RawMaterial));
        }
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<ResponseObject> deleteRawMaterial(@PathVariable Integer id){
        Optional<RawMaterial> RawMaterial = iRawMaterialService.findById(id);
        if(RawMaterial.isPresent()){
            iRawMaterialService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "delete object successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "nothing to delete here", "")
        );
    }

}
