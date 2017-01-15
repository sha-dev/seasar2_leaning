/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package de.sha.seasar2Learning.pdfDownload.action;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.RequestUtil;
import org.seasar.struts.util.ResponseUtil;

import de.sha.seasar2Learning.pdfDownload.form.RequiredDocumentForm;

public class IndexAction {

	@ActionForm
	@Resource
	protected RequiredDocumentForm requiredDocumentForm;

    @Execute(validator = false)
	public String index() {
        return "index.jsp";
	}

    @Execute(validator = false)
	public String print() throws IOException {
    	RequiredDocumentForm reqForm= (RequiredDocumentForm)RequestUtil.getRequest().getAttribute("requiredDocumentForm");
    	//下記２つの結果は一緒
    	System.out.println(reqForm.getMultiBox());
    	System.out.println(requiredDocumentForm.getMultiBox());
    	final String INPUT_FILE_NAME = "C:/test.pdf";
    	final String OUTPUT_FILE_NAME = "download.pdf";

		try {
			HttpServletResponse res = ResponseUtil.getResponse();
	    	res.setContentType("application/pdf");
	    	// inlineが直接開く、attachmentはダウンロード。初期値はattachment。
			res.setHeader("Content-Disposition", "inline; filename=\"" + OUTPUT_FILE_NAME + "\"");
			InputStream is = new FileInputStream(INPUT_FILE_NAME);

	        BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());

            byte buf[] = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            out.flush();

	    	//ResponseUtil.download(OUTPUT_FILE_NAME, is);
            // これを使うと便利そうだけど、responseHeaderへの値の更新などが無視される？

            out.close();
	    	is.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
    	return null;
	}
}
