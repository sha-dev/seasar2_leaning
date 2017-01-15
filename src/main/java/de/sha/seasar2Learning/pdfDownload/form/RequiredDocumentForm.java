package de.sha.seasar2Learning.pdfDownload.form;

import java.util.List;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;



@Component(instance=InstanceType.REQUEST)
public class RequiredDocumentForm {

	private List<String> multiBox;

	public List<String> getMultiBox() {
		return multiBox;
	}

	public void setMultiBox(List<String> multiBox) {
		this.multiBox = multiBox;
	}


}
