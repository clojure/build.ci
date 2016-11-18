<?xml version='1.0' encoding='UTF-8'?>
<hudson>
  <version>1.386</version>
  <numExecutors>2</numExecutors>
  <mode>NORMAL</mode>
  <useSecurity>true</useSecurity>
  <authorizationStrategy class="hudson.security.ProjectMatrixAuthorizationStrategy">
    <permission>hudson.model.Hudson.Administer:chrisredinger</permission>
    <permission>hudson.model.Hudson.Administer:richhickey</permission>
    <permission>hudson.model.Hudson.Administer:stuart.halloway</permission>
    <permission>hudson.model.Hudson.Administer:stuartsierra</permission>
    <permission>hudson.model.Hudson.Administer:alexmiller</permission>
    <permission>hudson.model.Hudson.Read:anonymous</permission>
    <permission>hudson.model.Item.Read:anonymous</permission>
  </authorizationStrategy>
  <securityRealm class="hudson.security.HudsonPrivateSecurityRealm">
    <disableSignup>true</disableSignup>
    <enableCaptcha>false</enableCaptcha>
  </securityRealm>
  <disableRememberMe>false</disableRememberMe>
  <projectNamingStrategy class="jenkins.model.ProjectNamingStrategy$DefaultProjectNamingStrategy"/>
  <workspaceDir>${ITEM_ROOTDIR}/workspace</workspaceDir>
  <buildsDir>${ITEM_ROOTDIR}/builds</buildsDir>
  <systemMessage>&lt;p&gt;Clojure build server, deploying to &lt;a href=&quot;https://oss.sonatype.org/&quot;&gt;Sonatype OSS&lt;/a&gt;. See &lt;a href=&quot;http://dev.clojure.org/display/doc/Maven+Settings+and+Repositories&quot;&gt;Maven Settings and Repositories&lt;/a&gt; on the Clojure Wiki for more information.&#xd;
&lt;p&gt;All projects build on Sun/Oracle JDK 1.6. "-test-matrix" jobs test multiple JDKs and Clojure versions.&lt;/p&gt;</systemMessage>
  <jdks>
    $jdks:{ jdk |<jdk>
  <name>$jdk.name$</name>
  <home>$jdk.home$</home>
  <properties/>
</jdk>}; separator="\n"$
  </jdks>
  <viewsTabBar class="hudson.views.DefaultViewsTabBar"/>
  <myViewsTabBar class="hudson.views.DefaultMyViewsTabBar"/>
  <clouds/>
  <quietPeriod>5</quietPeriod>
  <scmCheckoutRetryCount>0</scmCheckoutRetryCount>
  <views>
    <hudson.model.AllView>
      <owner class="hudson" reference="../../.."/>
      <name>All</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
    </hudson.model.AllView>
    <listView>
      <owner class="hudson" reference="../../.."/>
      <name>Clojure</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
      <jobNames>
        <comparator class="hudson.util.CaseInsensitiveComparator"/>
        <string>clojure</string>
        <string>clojure-test-matrix</string>
      </jobNames>
      <jobFilters/>
      <columns>
        <hudson.views.StatusColumn/>
        <hudson.views.WeatherColumn/>
        <hudson.views.JobColumn/>
        <hudson.views.LastSuccessColumn/>
        <hudson.views.LastFailureColumn/>
        <hudson.views.LastDurationColumn/>
        <hudson.views.BuildButtonColumn/>
      </columns>
      <recurse>false</recurse>
    </listView>
    <listView>
      <owner class="hudson" reference="../../.."/>
      <name>Contrib</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
      <jobNames>
        <comparator class="hudson.util.CaseInsensitiveComparator" reference="../../../listView/jobNames/comparator"/>
        $libs:{ name | <string>$name$</string>}; separator="\n"$
      </jobNames>
      <jobFilters/>
      <columns>
        <hudson.views.StatusColumn/>
        <hudson.views.WeatherColumn/>
        <hudson.views.JobColumn/>
        <hudson.views.LastSuccessColumn/>
        <hudson.views.LastFailureColumn/>
        <hudson.views.LastDurationColumn/>
        <hudson.views.BuildButtonColumn/>
      </columns>
      <recurse>false</recurse>
    </listView>
    <listView>
      <owner class="hudson" reference="../../.."/>
      <name>Support</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
      <jobNames>
        <comparator class="hudson.util.CaseInsensitiveComparator" reference="../../../listView/jobNames/comparator"/>
        <string>build.ci</string>
        <string>build.poms</string>
        <string>rebuild-all-libraries</string>
      </jobNames>
      <jobFilters/>
      <columns>
        <hudson.views.StatusColumn/>
        <hudson.views.WeatherColumn/>
        <hudson.views.JobColumn/>
        <hudson.views.LastSuccessColumn/>
        <hudson.views.LastFailureColumn/>
        <hudson.views.LastDurationColumn/>
        <hudson.views.BuildButtonColumn/>
      </columns>
      <recurse>false</recurse>
    </listView>
  </views>
  <primaryView>All</primaryView>
  <slaveAgentPort>0</slaveAgentPort>
  <label></label>
  <crumbIssuer class="hudson.security.csrf.DefaultCrumbIssuer">
    <excludeClientIPFromCrumb>false</excludeClientIPFromCrumb>
  </crumbIssuer>
  <nodeProperties/>
  <globalNodeProperties/>
  <disabledAdministrativeMonitors/>
</hudson>
