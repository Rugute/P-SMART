package org.openmrs.module.facespsmart.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by rugute on 2/28/18.
 */
public class PSMARTRestController extends BaseRestController {

    //protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.POST, value = "/receiveshr")
    @ResponseBody
    public Object receiveSHR(WebRequest request) {

        return new SimpleObject().add("sessionId", request.getSessionId()).add("authenticated", Context.isAuthenticated());
    }

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

}