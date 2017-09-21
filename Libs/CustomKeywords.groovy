

import com.kms.katalon.core.testobject.TestObject

import java.lang.String


def static "com.ea.utilities.CommonUtilities.CheckDropDownListElementExist"(
    	TestObject object	
     , 	String option	) {
    (new com.ea.utilities.CommonUtilities()).CheckDropDownListElementExist(
        	object
         , 	option)
}
