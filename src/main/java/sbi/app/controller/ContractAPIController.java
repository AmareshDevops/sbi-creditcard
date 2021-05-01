/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package sbi.app.controller;

import sbi.app.base.constant.Code;
import sbi.app.base.response.BasicResult;
import sbi.app.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(value = "contract", description = "合约 API")
@RequestMapping(value = "/v1")
public class ContractAPIController {

        @Autowired
        private ContractService contractService;


        @ApiOperation(value = "合约部署", notes = "", response = String.class, tags = {})
        @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class)})

        @RequestMapping(value = "/deploy/{cname}",
                produces = {"application/json"},
                method = RequestMethod.GET)
        ResponseEntity<BasicResult> contractDelpoy(@PathVariable String cname) {
            String caddr = contractService.delpoy(cname);
            BasicResult<String> basicResult = new BasicResult<>(Code.SUCCESS, caddr);
            return new ResponseEntity<>(basicResult, HttpStatus.OK);
        }
}
