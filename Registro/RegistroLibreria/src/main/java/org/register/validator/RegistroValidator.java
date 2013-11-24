package org.register.validator;

import org.register.model.Registro;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistroValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Registro.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Registro registro = (Registro) target;
		Integer edad = registro.getEdad();
		
		ValidationUtils.rejectIfEmpty(errors, "name", "registro.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "apellido", "registro.apellido.empty");
		
		if(registro.getIdVisible() == null ){
			errors.rejectValue("idVisible", "registro.visible.empty");
			
		}
			
		System.out.println(edad);
		if( edad != null && edad < 18 )
			errors.rejectValue("edad", "registro.edad.menor");
		
			
	}

}
