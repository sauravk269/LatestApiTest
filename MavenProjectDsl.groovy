job('First maven project via dsl'){
    description("first maven job jenerated on ${new Date()}")
    scm{
        git("https://github.com/sauravk269/LatestApiTest.git")
    }
    triggers{
        scm('*****')
    }
    steps{
        maven('clean package','')
    }
    publishers{
        archiveArtifacts'**/*.jar'
    }
}