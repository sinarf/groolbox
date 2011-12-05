#!/usr/bin/groovy
@Grab(group='org.apache.commons', module='commons-email', version='1.2')
import org.apache.commons.mail.*

if (args.length < 3 ){
	println "Missing parameters! Usage:"
	println "SendToKindle <smtpServer> <from> <to>"
	System.exit 1
}

def smtpServer = args[0]
def from = args[1]
def to = args[2]
def docFolder = "${System.getenv('HOME')}/Dropbox/_INBOX/kindle"

new File(docFolder).eachFile {	file ->
	
	EmailAttachment attachment = new EmailAttachment()
	attachment.setPath(file.canonicalPath)
	attachment.setDisposition(EmailAttachment.ATTACHMENT)

	MultiPartEmail email = new MultiPartEmail()
	email.setHostName(smtpServer)
	email.addTo(to)
	email.setFrom(from)
	email.setSubject("convert") // make amazon convert the file to kindle format.
	email.attach(attachment)

	println "Sending file $file to $to"
	email.send()
	println "deleting file $file"
	file.delete();
}

Thread.sleep 5000
