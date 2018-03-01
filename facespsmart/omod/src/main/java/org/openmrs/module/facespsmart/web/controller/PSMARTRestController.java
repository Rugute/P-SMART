package org.openmrs.module.facespsmart.web.controller;

<<<<<<< HEAD
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.facespsmart.jsonvalidator.mapper.SHRProcessor;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.stereotype.Controller;
=======
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
>>>>>>> 56fb629d763c26255979a47e5f730c9cd6ea7a64
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by rugute on 2/28/18.
 */
<<<<<<< HEAD
@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/smartcard")
public class PSMARTRestController extends BaseRestController {

    protected final Log log = LogFactory.getLog(getClass());
=======
public class PSMARTRestController extends BaseRestController {

    //protected final Log log = LogFactory.getLog(getClass());
>>>>>>> 56fb629d763c26255979a47e5f730c9cd6ea7a64

    @RequestMapping(method = RequestMethod.POST, value = "/receiveshr")
    @ResponseBody
    public Object receiveSHR(WebRequest request) {

<<<<<<< HEAD
        SHRProcessor processSHR = new SHRProcessor();
       processSHR.getOrCreatePatient();

        return new SimpleObject().add("sessionId", request.getSessionId()).add("authenticated", Context.isAuthenticated());

    }
// Works perfect
=======
        return new SimpleObject().add("sessionId", request.getSessionId()).add("authenticated", Context.isAuthenticated());
    }

>>>>>>> 56fb629d763c26255979a47e5f730c9cd6ea7a64
    @RequestMapping(method = RequestMethod.GET, value = "/prepareshr")
    @ResponseBody
    public Object prepareSHR(WebRequest request) {
        return new SimpleObject().add("sessionId", request.getSessionId()).add("authenticated", Context.isAuthenticated());
    }

    /**
     * @see org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController#getNamespace()
     */

    @Override
    public String getNamespace() {
        return "v1/facespsmart";
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 56fb629d763c26255979a47e5f730c9cd6ea7a64
