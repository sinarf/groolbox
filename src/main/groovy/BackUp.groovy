import groovyjarjarcommonscli.Options;


/**
 * simple script de backup. 
 * 
 * author Michel Blavin
 */


// creation of the command line arguments
def cliBuilder = new CliBuilder()
cliBuilder.s(longOpt: 'sourcedir', argName: 'sourcedir', args: 1, required: true, 'source directory to zip.')
cliBuilder.d(longOpt: 'destfile', argName: 'destfile', args: 1, required: false, 'destination file, if not provided backup.zip is used')
cliBuilder.h(longOpt: 'help', required: false, 'show usage information')
cliBuilder.debug(longOpt: 'debug', required: false, 'debug mode, means more logging.')

// parsing the command line arguments.
def options = cliBuilder.parse(args)
if (!options)
    return
if (options.h) {
    cliBuilder.usage();
    return
}
// end of command line arguments

def timestamp = new java.text.SimpleDateFormat("yyyyMMdd-hhmm").format(new Date())
def zipExtension = ".zip"

def ant = new AntBuilder()

def destfile = options.d ?: "backup-${timestamp}$zipExtension"
def basedir = options.s ?: options.s

// check some environement. 
if (new File(destfile).exists()) 
{
    println "Destination file already exists. Please choose another name. "
    System.exit 1
}

// 
println "The contents of $basedir will be zipped into $destfile"
ant.zip(destfile: destfile, basedir: basedir, includes: "**")


