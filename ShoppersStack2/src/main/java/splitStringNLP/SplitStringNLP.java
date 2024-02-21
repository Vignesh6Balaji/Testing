
package splitStringNLP;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

@Component("LIC16839_PJT1006_PE_NLP160d7d61-8512-4002-8669-c8abe7a39922")
public class SplitStringNLP implements Nlp {
    @InputParams({@InputParam(name = "Input String", type = "java.lang.String"), 
    	@InputParam(name = "Regex", type = "java.lang.String"), 
    	@InputParam(name = "Index", type = "java.lang.Integer")})
    @ReturnType(name = "Return", type = "java.lang.String")

      @Override
      public List<String> getTestParameters() throws NlpException {
        List<String> params = new ArrayList<>();
        return params;
      }

      @Override
      public StringBuilder getTestCode() throws NlpException {
        StringBuilder sb = new StringBuilder();
        return sb;
      }
      @Override
      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          String string = (String) attributes.get("Input String");
          String regex = (String) attributes.get("Regex");
          int i=(Integer) attributes.get("Index");
          String s="";

          // Your program element business logic goes here ...

          try {
			String str[]=string.split(regex);
			s=str[i];
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Split string is passed");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Split string is failed");
		}
          nlpResponseModel.getAttributes().put("Return", s);
          return nlpResponseModel;
      }
  } 